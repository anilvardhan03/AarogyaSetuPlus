package ArogyaSetuPlus.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/CHII-web-api")
public class StateCheckingController {
    @GetMapping("/find/{CHIINumber}")
    public ResponseEntity<?> getStateByCHIINumber(@PathVariable String CHIINumber) {
	if (CHIINumber.length() <= 10) {
	    return new ResponseEntity<String>("CHII Number Must be Greater than 10 Digits", HttpStatus.BAD_REQUEST);
	}
	String stateCode = CHIINumber.substring(0, 2).toUpperCase();
	String stateName;
	if (stateCode.equalsIgnoreCase("AP")) {
	    stateName = "Andhra Pradesh";
	} else if (stateCode.equalsIgnoreCase("AR")) {
	    stateName = "Arunachal Pradesh";
	} else if (stateCode.equalsIgnoreCase("AS")) {
	    stateName = "Assam";
	} else if (stateCode.equalsIgnoreCase("BR")) {
	    stateName = "Bihar";
	} else if (stateCode.equalsIgnoreCase("CG")) {
	    stateName = "Chhattisgarh";
	} else if (stateCode.equalsIgnoreCase("CH")) {
	    stateName = "Chandigarh";
	} else if (stateCode.equalsIgnoreCase("DD")) {
	    stateName = "Dadra and Nagar Haveli and Daman and Diu";
	} else if (stateCode.equalsIgnoreCase("DL")) {
	    stateName = "Delhi";
	} else if (stateCode.equalsIgnoreCase("GA")) {
	    stateName = "Goa";
	} else if (stateCode.equalsIgnoreCase("GJ")) {
	    stateName = "Gujarat";
	} else if (stateCode.equalsIgnoreCase("HR")) {
	    stateName = "Haryana";
	} else if (stateCode.equalsIgnoreCase("HP")) {
	    stateName = "Himachal Pradesh";
	} else if (stateCode.equalsIgnoreCase("JH")) {
	    stateName = "Jharkhand";
	} else if (stateCode.equalsIgnoreCase("JK")) {
	    stateName = "Jammu and Kashmir";
	} else if (stateCode.equalsIgnoreCase("KA")) {
	    stateName = "Karnataka";
	} else if (stateCode.equalsIgnoreCase("KL")) {
	    stateName = "Kerala";
	} else if (stateCode.equalsIgnoreCase("LA")) {
	    stateName = "Ladakh";
	} else if (stateCode.equalsIgnoreCase("LD")) {
	    stateName = "Lakshadweep";
	} else if (stateCode.equalsIgnoreCase("MP")) {
	    stateName = "Madhya Pradesh";
	} else if (stateCode.equalsIgnoreCase("MH")) {
	    stateName = "Maharashtra";
	} else if (stateCode.equalsIgnoreCase("MN")) {
	    stateName = "Manipur";
	} else if (stateCode.equalsIgnoreCase("ML")) {
	    stateName = "Meghalaya";
	} else if (stateCode.equalsIgnoreCase("MZ")) {
	    stateName = "Mizoram";
	} else if (stateCode.equalsIgnoreCase("NL")) {
	    stateName = "Nagaland";
	} else if (stateCode.equalsIgnoreCase("OR")) {
	    stateName = "Odisha";
	} else if (stateCode.equalsIgnoreCase("PB")) {
	    stateName = "Punjab";
	} else if (stateCode.equalsIgnoreCase("PY")) {
	    stateName = "Puducherry";
	} else if (stateCode.equalsIgnoreCase("RJ")) {
	    stateName = "Rajasthan";
	} else if (stateCode.equalsIgnoreCase("SK")) {
	    stateName = "Sikkim";
	} else if (stateCode.equalsIgnoreCase("TN")) {
	    stateName = "Tamil Nadu";
	} else if (stateCode.equalsIgnoreCase("TG")) {
	    stateName = "Telangana";
	} else if (stateCode.equalsIgnoreCase("TR")) {
	    stateName = "Tripura";
	} else if (stateCode.equalsIgnoreCase("UP")) {
	    stateName = "Uttar Pradesh";
	} else if (stateCode.equalsIgnoreCase("UK")) {
	    stateName = "Uttarakhand";
	} else if (stateCode.equalsIgnoreCase("WB")) {
	    stateName = "West Bengal";
	} else {
	    return new ResponseEntity<>("Invalid CHII Number Please Re-Check", HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<>(stateName, HttpStatus.OK);
    }
}
