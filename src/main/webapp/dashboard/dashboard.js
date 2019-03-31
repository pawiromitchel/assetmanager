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
                                    <td>
                                        <button>
                                            <a href="./../asset-management/edit-asset.html?id=${item.assetId}">Edit</a>
                                        </button>
                                        <button>Delete</button>
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

function remove(item) {

}
