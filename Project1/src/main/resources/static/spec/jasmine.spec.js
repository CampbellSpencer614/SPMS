const { hasUncaughtExceptionCaptureCallback } = require("process");

function funcToTest(input) {
    if (typeof input === 'number') {
        return input + 2;
    } else if (typeof input === 'string') {
        return input + ' two';
    } else {
        return null;
    }
}

describe ('jasmine example', () => {
    it ('should add 2 to a number', () => {
        expect(funcToTest(4)).toBe(6);
    });
    it ('should add two to a string', () => {
        expect(funcToTest('hello')).toBe('hello two');
    });
    it ('should return null if not a number or string', () => {
        let obj = {};
        expect(funcToTest(obj)).toBe(null);
    });
});