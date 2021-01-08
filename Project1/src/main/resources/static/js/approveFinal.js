//let addCatMenuOpen = false;
//setup();
checkLogin().then(getPitchs);
var stage =false;


async function getPitchs() {
    let url = baseUrl + '/pitch/all';
    let response = await fetch(url);
    if (response.status === 200) {
        let pitchs = await response.json();
        populatePitchs(pitchs);
    }
}

function populatePitchs(pitchs) {
    let finalSection = document.getElementById('finalSection');
    finalSection.innerHTML = '';

    if (pitchs.length > 0) {
        let table = document.createElement('table');
        table.id = 'pitchTable';

        table.innerHTML = `
            <tr>
                <th>Title</th>
                <th>Draft</th>
				<th></th>
				<th></th>
            </tr>
        `;

        for (let pitch of pitchs) {
			stage =false;
            let tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${pitch.story.title}</td>
                <td>${pitch.story.draft.story}</td>
            `;
            let td = document.createElement('td');
            tr.appendChild(td);

            let acceptBtn = document.createElement('button');
			acceptBtn.id = pitch.id;
            acceptBtn.type = 'button';
            acceptBtn.textContent = 'Accept';

            let btnTd = document.createElement('td');
            btnTd.appendChild(acceptBtn);
			
            tr.appendChild(btnTd);
			if((pitch.story.genre.genre==loggedUser.committees[0].genre||pitch.pitch_status.general.id==loggedUser.id)
			&&pitch.pitchStatus.status=='final'){
				table.appendChild(tr);
			}
            
             if(loggedUser.user_role.id==4){
                acceptBtn.addEventListener('click', accept);
            }
        }

        finalSection.appendChild(table);
    } else {
        finalSection.innerHTML = 'No pitches are available.';
    }
}


async function accept(){	
	let pitch;
	 let url = baseUrl + '/pitch/' + event.target.id;
     let response = await fetch(url);
	if (response.status === 200) {
         pitch = await response.json();
    }else{
	alert('Something went wrong.');
	}
	let updatedStatus = pitch.pitchStatus
	updatedStatus.status='Approved';	
	   url = baseUrl + '/pitch/' + loggedUser.id;
        response = await fetch(url, {method:'PUT', body:JSON.stringify(updatedStatus)});
        if (response.status === 202) {
          //  alert('Updated successfully.');
        } else {
            alert('Something went wrong.');
        }
getPitchs()
}
