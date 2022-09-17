const ajax = new Ajax();

document.getElementById("input").addEventListener("keyup", function ({keyCode}) {
    if (keyCode === 13)
        ajax.post(
            '/liveStreaming/getLiveLink',
            {'url': document.getElementById('input').value},
            function (response) {
                window.location.href = '/liveStreaming/download/' + complex(response.data,65537);
            }
        );
});