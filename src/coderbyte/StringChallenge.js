function StringChallenge(str) {
    let tagStart = str.match(/<\w+>/g);
    let tagEnd = str.match(/(<\/\w+>)/g);

    const tagMap = {
        '<div>': '</div>', '<p>': '</p>', '<i>': '</i>', '<em>': '</em>', '<b>': '</b>',
    };

    for (const element of tagStart) {
        let closingTag = tagMap[element];
        if (closingTag) {
            const closingTagIndex = tagEnd.indexOf(closingTag);
            if (closingTagIndex > -1) {
                tagEnd.splice(closingTagIndex, 1);
            } else {
                return element.replace(/<|>/g, '')
            }
        }
    }
    return "true";

}

// keep this function call here
console.log(StringChallenge("<div><div><b></b></div></p>"));


