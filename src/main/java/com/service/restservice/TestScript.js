function testFunction() {
    const request = '<put ur soap request here';


    if(request.includes("<soap:Header>") && request.includes("</soap:Header>")){
        const regex = /(<soap:Header>)(.*)(<\/soap:Header>)/g;
        console.log(request.replace(regex, '<soap:Header><soap:newToken>customHeader</soap:newToken></soap:Header>'));
    } else if(request.includes("<soap:Header/>")){
        request.replace("<soap:Header/>","");
    }
}

testFunction();
