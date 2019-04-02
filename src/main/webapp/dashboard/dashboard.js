function getAssets(apiUrl) {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState > 3 && xhttp.status == 200) {
            if (this.responseText) {
                // handle response here
                const items = JSON.parse(this.responseText);
                items.forEach(item => {
                    const html =
                        `
                                <tr>
                                    <td>${item.assetDescription}</td>
                                    <td>${item.macAddress}</td>
                                    <td>${item.serialNumber}</td>
                                    <td>${item.estimatedLifespan}</td>
                                    <td>${item.status ? item.status.status : ''}</td>
                                    <td>${item.category ? item.category.name : ''}</td>
                                    <td>${item.createdByEmployee ? item.createdByEmployee.username : ''}</td>
                                    <td>${item.updatedByEmployee ? item.updatedByEmployee.username : ''}</td>
                                    <td>
                                        <a class="btn btn-info" href="./../asset-management/edit-asset.html?id=${item.assetId}">Edit</a>
                                        <button class="btn btn-danger" onclick="deleteAsset('${apiUrl}', ${item.assetId})">Delete</button>
                                    </td>
                                </tr>
                            `;
                    document.getElementById("assets").innerHTML += html;
                });
            } else {
                alert("Something went wrong retreiving the data");
            }
        }
    };
    xhttp.open("GET", `${apiUrl}/asset/list`, true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send();
}

function deleteAsset(apiUrl, assetId) {
    var dialogBox = confirm(`Do you really with to delete the selected asset?`);
    if (dialogBox) {
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState > 3 && xhttp.status == 200) {
                if (this.responseText == "NOT_ACCEPTABLE") {
                    alert(`Not allowed to remove this asset`);
                } else {
                    alert(`${assetId} succesfully deleted`);
                    // location.reload();
                }
            }
        };
        xhttp.open("DELETE", `${apiUrl}/asset/${assetId}`, true);
        xhttp.setRequestHeader("Content-Type", "application/json");
        xhttp.send();
    } else {
        txt = "You pressed Cancel!";
    }

}
