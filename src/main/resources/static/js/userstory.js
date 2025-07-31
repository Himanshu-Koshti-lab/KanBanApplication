function showToast(message, isError = false) {
    const toast = document.getElementById("toast");
    toast.className = "toast show" + (isError ? " error" : "");
    toast.textContent = message;
    setTimeout(() => { toast.className = toast.className.replace("show", ""); }, 3000);
}

function fetchStoriesAndUpdateTable() {
    fetch("/v1/api/getUserStories")
        .then(res => res.json())
        .then(data => {
            const tbody = document.getElementById("storyBody");
            tbody.innerHTML = "";
            data.forEach(story => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${story.id}</td>
                    <td>${story.title}</td>
                    <td>${story.description}</td>
                    <td>${story.status}</td>
                    <td>${new Date(story.startTime).toLocaleString()}</td>
                    <td>${new Date(story.lastUpdate).toLocaleString()}</td>
                `;
                tbody.appendChild(row);
            });
        });
}

document.getElementById("createForm").addEventListener("submit", function(e) {
    e.preventDefault();
    const title = document.getElementById("title").value;
    const desc = document.getElementById("desc").value;

    fetch(`/v1/api/create?title=${encodeURIComponent(title)}&desc=${encodeURIComponent(desc)}`, {
        method: "POST"
    }).then(res => {
        if (res.ok) {
            showToast("User story created!");
            fetchStoriesAndUpdateTable();
        } else {
            res.text().then(msg => showToast("Error: " + msg, true));
        }
    });
});

document.getElementById("statusForm").addEventListener("submit", function(e) {
    e.preventDefault();
    const id = document.getElementById("updateId").value;
    const status = document.getElementById("newStatus").value;

    fetch(`/v1/api/updateStatus?id=${id}&status=${encodeURIComponent(status)}`, {
        method: "POST"
    }).then(res => {
        if (res.ok) {
            showToast("Status updated!");
            fetchStoriesAndUpdateTable();
        } else {
            res.text().then(msg => showToast("Error: " + msg, true));
        }
    });
});

// On page load
fetchStoriesAndUpdateTable();
