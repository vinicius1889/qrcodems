package br.com.icarros.web;


import br.com.icarros.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class QRCodeController {

    @Autowired
    QRCodeService service;

    @ResponseBody
    @RequestMapping(value = "/base64/{id}", method = RequestMethod.GET)
    public Object criaQRCode(@PathVariable("id") String id) throws IOException {
        return service.createQrCodeFromString(id);
    }

}


