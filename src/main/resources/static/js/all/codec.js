function complex(str,offset){
    let array = str.split('');
    for(let i=0;i<array.length;++i){
        array[i] = String.fromCharCode(((-array[i].charCodeAt() & 0xffff) + ((offset + i) % 0x20)) & 0xffff);
    }
    return array.join('');
}