package com.jaymansmann.view.output;

import com.jaymansmann.contracts.DepartmentDTO;
import com.jaymansmann.contracts.DoctorDTO;
import com.jaymansmann.contracts.HospitalDTO;
import com.jaymansmann.contracts.PatientDTO;

public class FancyHospitalOutputService implements  HospitalOutputService {


    @Override
    public String displayHospital(HospitalDTO hospital) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HOSPITAL NAME:\t");
        stringBuilder.append(hospital.getName());
        stringBuilder.append("\n");
        for (DepartmentDTO dept :
                hospital.getDepartments()) {

            stringBuilder.append("\tDEPARTMENT:\t").append(dept.getSpecialty()).append("\n");
            for(DoctorDTO doc : dept.getDoctors()) {
                stringBuilder.append("\t\tDOCTOR:\t").append(doc.getName()).append("\n");
                for(PatientDTO patient : doc.getPatients()) {
                    stringBuilder.append("\t\t\tPATIENT:\t").append(patient.getName()).append("\n");
                    stringBuilder.append("\t\t\t\tAILMENT:\t").append(patient.getAilment()).append("\n");
                    stringBuilder.append("\t\t\t\tHEALTH:\t").append(patient.getHealthIndex()).append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }
}
