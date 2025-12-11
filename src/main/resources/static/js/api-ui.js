const apiBase = "http://localhost:8080/posts";

function showResponse(data) {
    document.getElementById("responseBox").innerText = JSON.stringify(data, null, 2);
}

async function getPosts() {
    const res = await fetch(apiBase);
    showResponse(await res.json());
}

async function createPost() {
    const post = {
        title: "Nieuwe post",
        content: "Dit is een test vanuit de UI."
    };

    const res = await fetch(apiBase, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(post)
    });

    showResponse(await res.json());
}

async function updatePost() {
    const id = prompt("Welke post ID wil je updaten?");
    if (!id) return;

    const updated = {
        title: "Geüpdatete titel",
        content: "Nieuwe content."
    };

    const res = await fetch(`${apiBase}/${id}`, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(updated)
    });

    showResponse(await res.json());
}

async function deletePost() {
    const id = prompt("Welke post ID wil je verwijderen?");
    if (!id) return;

    const res = await fetch(`${apiBase}/${id}`, {
        method: "DELETE"
    });

    showResponse({status: "Post verwijderd", id});
}
