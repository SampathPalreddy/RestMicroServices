function testFunction() {
    const request = '<soap:Envelope xmlns:soap env="http://schemas.xmlsoap.org/soap/envelope/" ' +
        'xmlns:usb="http://soa.usbank.com/USBSOACoreComponentsLibrary_V_3_0" ' +
        'xmlns:xslt="http://xml.apache.org/xslt" ' +
        'xmlns:soap="http://www.w3.org/2003/05/soap-envelope" ' +
        'xmlns:heal="http://www.usbank.com/epayments/ws/schemas/healthcheck"> ' +
        '<soap:Header><soap:userNameToken>QUS.epymtservice.com</soap:userNameToken></soap:Header> ' +
        '<soap:Body/> \n' +
        '</soap:Envelope> ' +
        '<soap:Envelope xmlns:soap env="http://schemas.xmlsoap.org/soap/envelope/" ' +
        'xmlns:usb="http://soa.usbank.com/USBSOACoreComponentsLibrary_V_3_0" ' +
        'xmlns:xslt="http://xml.apache.org/xslt" ' +
        'xmlns:soap="http://www.w3.org/2003/05/soap-envelope" ' +
        'xmlns:heal="http://www.usbank.com/epayments/ws/schemas/healthcheck"> ' +
        '<soap:Header> ' +
        '<soap:userNameToken>QUS.epymtservice.com</soap:userNameToken> ' +
        '</soap:Header> ' +
        '<soap:Body/> ' +
        '</soap:Envelope> ' +
        '<heal:HealthCheckRequest xmlns:soap="http://www.w3.org/2003/05/soap-envelope" ' +
        'xmlns:epay="http://www.usbank.com/epayments/ws/schemas/epaywebservice" ' +
        'xmlns:heal="http://www.usbank.com/epayments/ws/schemas/healthcheck">??</heal:HealthCheckRequest>';


    if(request.includes("<soap:Header>") && request.includes("</soap:Header>")){
        const regex = /(<soap:Header>)(.*)(<\/soap:Header>)/g;
        console.log(request.replace(regex, '<soap:Header><soap:newToken>customHeader</soap:newToken></soap:Header>'));
    } else if(request.includes("<soap:Header/>")){
        request.replace("<soap:Header/>","");
    }
}

testFunction();
