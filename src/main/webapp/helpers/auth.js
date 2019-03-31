/**
 * Check if the user is logged in by calling the SessionStorage API
 */
function isLoggedIn() {
    if (!sessionStorage.getItem("credentials")) {
        console.log("User is not logged in, will be redirected to the login screen");
        return false;
    }
    console.log("User is logged in");
    return true;
}

