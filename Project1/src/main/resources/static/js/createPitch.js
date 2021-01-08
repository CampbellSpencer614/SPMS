checkLogin().then(createPitch);

var genres;
var genreArr=[];

async function createPitch() {
    let pitchSection = document.getElementById('pitchSection');
	
	 pitchSection.innerHTML = `
           <label for="title">Title </label><br/>
           <input id="title" name="user" type="text" />
			<br/>
			<label for="Tagline">Tagline </label><br/>
            <input id="Tagline" name="user" type="text" />
			<br/>
			<label for="Desc">Detailed description </label><br/>
            <textarea id="Desc" name="user" type="text" rows="10" cols="58" > </textarea>
			<br/>
			<label for="Gen">Genre &nbsp &nbsp &nbsp &nbsp Story type</label><br/>
            <select id="genreDrop" name="genre" > </select>
        `;
	 setGenres();


	 pitchSection.innerHTML +='<select name="storyType" id="storyType">'+
'<option value="1">Novel</option><option value="2">Novella</option><option value="3">Short story</option>'+
'<option value="4">Article</option></select> <button type="button" id="submit">Submit</button>';

document.getElementById('submit').onclick = sendPitch;
}

async function setGenres(){
	let url = baseUrl + '/genres';
    let response = await fetch(url);
    if (response.status === 200) {
        genres = await response.json();
    }
	let drop = document.getElementById('genreDrop');

	for (let g of genres) {
		 let option = g.genre;
		 let e = document.createElement("option");
   		 e.text = option;
   		 e.value = g.id;;
   		 drop.add(e);
	}
}

async function sendPitch(){
	let url = baseUrl + '/pitch?';
	url += 'username=' + loggedUser.username + '&';
    url += 'title=' + document.getElementById('title').value + '&';
	url += 'tagline=' + document.getElementById('Tagline').value + '&';
	url += 'desc=' + document.getElementById('Desc').value + '&';
	url += 'storytype=' + document.getElementById('storyType').value + '&';
    url += 'genre=' + document.getElementById('genreDrop').value;
    let response = await fetch(url, {method: 'PUT'});
    
    switch (response.status) {
        case 201: // successful
             pitchSection.innerHTML = "Submitted";
            break;
        default: // other error
            alert('Something went wrong.');
            break;
    }
}
