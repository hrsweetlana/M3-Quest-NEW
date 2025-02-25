// function getQuizURI() {
//     const index = getSelectedQuizId();
//     let s = `/quiz?index=${index}`;
//     console.log(s);
//     return index !== undefined ? s : null;
// }
//
// function getSelectedQuizId() {
//     const options = document.querySelectorAll('input[name="quiz"]');
//     let selectedIndex;
//
//     for (const option of options) {
//         if (option.checked) {
//             selectedIndex = option.id.replace('quiz', '');
//             break;
//         }
//     }
//     return selectedIndex;
// }
//
// function redirectToPage(pageUrl) {
//     if (pageUrl !== null) {
//         window.location.href = pageUrl;
//     } else {
//         alert("Link error.");
//     }
// }


function getQuizURI() {
    const index = getSelectedQuizId();
    console.log('Selected Quiz ID:', index);

    let s = "/quiz?index=" + index;
    console.log(s);
    return index !== undefined ? s : null;
}

function getSelectedQuizId() {
    const options = document.querySelectorAll('input[name="quiz"]');
    let selectedIndex;

    for (const option of options) {
        if (option.checked) {
            selectedIndex = option.id.replace('quiz', '');
            break;
        }
    }
    console.log('getSelectedQuizId result:', selectedIndex);
    return selectedIndex;
}

function redirectToPage(pageUrl) {
    if (pageUrl !== null) {
        window.location.href = pageUrl;
    } else {
        alert("Link error.");
    }
}
