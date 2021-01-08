import { browser, element } from "protractor";

/* 
    this won't actually work because plain js doesn't
    like export/import without modules :( so just keep
    this concept in mind for when we use protractor
    with angular :)
*/

export class CatAppPage {
    navigateTo() {
        return browser.get('http://localhost:8080');
    }

    getViewCatsLink() {
        return element(by.partialLinkText('View'));
    }
}