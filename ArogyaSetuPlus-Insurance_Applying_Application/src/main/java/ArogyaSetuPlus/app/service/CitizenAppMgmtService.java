package ArogyaSetuPlus.app.service;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import ArogyaSetuPlus.app.bindings.CitizenRegistrationInputs;
import ArogyaSetuPlus.app.entity.CitizenRegistrationEntity;
import ArogyaSetuPlus.app.repository.ICitizenRegistrationRepository;

@Service
public class CitizenAppMgmtService implements ICitizenRegistrationMgmtService {
    @Autowired
    private ICitizenRegistrationRepository registrationRepo;
    @Autowired
    //private RestTemplate template;
    private WebClient webClient;
    @Value("${ar.CHII-web-url}")
    private String endpointUrl;
    @Value("${ar.targetName}")
    private String targetName;

    @Override
    public Integer registerCitizenApplcation(CitizenRegistrationInputs Inputs){

	if (Inputs.getChiiNumber() == null || Inputs.getChiiNumber().trim().isEmpty()) {
	    throw new IllegalArgumentException("CHII Number Must Not Be Empty");
	}
	String stateName = webClient.get().uri(endpointUrl, Inputs.getChiiNumber()).retrieve().bodyToMono(String.class)
		.block();
	/*ResponseEntity<String> response = template.exchange(endpointUrl, HttpMethod.GET, null, String.class,
	    Inputs.getChiiNumber());
	String stateName = response.getBody();*/
	if (stateName.equalsIgnoreCase(targetName)) {
	    /* if (Inputs.getFullName() == null || Inputs.getFullName().trim().isEmpty() || Inputs.getAddress() == null
	        || Inputs.getAddress().trim().isEmpty() || Inputs.getChiiNumber() == null
	        || Inputs.getChiiNumber().trim().isEmpty() || Inputs.getDob() == null || Inputs.getEmail() == null
	        || Inputs.getEmail().trim().isEmpty() || Inputs.getGender() == null
	        || Inputs.getPhoneNumber() == null || Inputs.getPhoneNumber().trim().isEmpty()) {
	    throw new IllegalArgumentException("Input Can't Be Empty Please Fill All the Details");
	    }*/

	    if (Inputs.getFullName() == null || Inputs.getFullName().trim().isEmpty()) {
		throw new IllegalArgumentException("Full Name Can't Be Empty.");
	    }
	    if (Inputs.getPhoneNumber().length() != 10 || !Inputs.getPhoneNumber().matches("\\d{10}")) {
		throw new IllegalArgumentException("Phone number must be 10 digits.");
	    }
	    if (!Arrays.asList("Male", "Female", "Other").contains(Inputs.getGender())) {
		throw new IllegalArgumentException("Gender must be 'Male', 'Female', or 'Other'.");
	    }
	    if (!	Inputs.getEmail().contains("@")) {
		throw new IllegalArgumentException("Email must contain '@'.");
	    }
	    if (!Inputs.getDob().isBefore(LocalDate.now())) {
		throw new IllegalArgumentException("Date of Birth must be in the past.");
	    }
	    if (!Arrays.asList("Male", "Female", "Other").contains(Inputs.getGender())) {
		throw new IllegalArgumentException("Gender must be 'Male', 'Female', or 'Other'.");
	    }
	    if (Inputs.getAddress() == null || Inputs.getAddress().trim().isEmpty()) {
		throw new IllegalArgumentException("Address Can't Be Empty.");
	    }

	    CitizenRegistrationEntity entity = new CitizenRegistrationEntity();
	    BeanUtils.copyProperties(Inputs, entity);
	    entity.setStateName(stateName);
	    //entity.setCHIINumber(Inputs.getChiiNumber());
	    int appId = registrationRepo.save(entity).getAppId();
	    return appId;
	}
	return 0;
    }
}
