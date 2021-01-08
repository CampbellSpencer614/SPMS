const { browser, element } = require("protractor");

// this makes it so that protractor doesn't get angry with you
// for this project not being an angular project
browser.ignoreSynchronization = true;

describe ('protractor example', () => {
    beforeAll(() => {
        browser.get('http://localhost:8080');
    });
    it('should go to the view cats page', () => {
        element(by.partialLinkText('View')).click();
        let header = element(by.tagName('h3'));
        expect(header.getText()).toEqual('Available Cats');
    });
});