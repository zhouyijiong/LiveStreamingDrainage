class Ajax {
    constructor() {
    }

    get(url, formData, success) {
        return this.send('GET', url, 'json', formData, success);
    }

    post(url, formData, success) {
        return this.send('POST', url, 'json', formData, success);
    };

    send(type, url, dataType, formData, success) {
        $.ajax({
            type: type,
            url: url,
            dataType: dataType,
            data: formData,
            success: success//, error: error
        });
    }
}