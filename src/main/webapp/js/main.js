/**
 * Check if the user is logged in by calling the SessionStorage API
 */
function isLoggedIn() {
    if(!sessionStorage.getItem("credentials")){
        return false;
    }
    return true;
}