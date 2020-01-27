package com.idgenerali.mybackend;


import com.idgenerali.mybackend.model.Status;
import com.idgenerali.mybackend.service.LeadsService;
import com.idgenerali.mybackend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.List;


@SpringBootApplication
public class MyBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBackendApplication.class, args);
	}
}

@Component
class Commands implements CommandLineRunner{

	@Autowired
	private LeadsService leadsService;

	@Autowired
	private StatusService statusService;

//	static String splitEmail(String email){
//		String[] emails = email.split(",");
//		String email1  = emails[0];
//		String email2 = emails[1];
//		String result = "Email 1 : "+email1 +","+"Email 2: "+email2;
//		return result;
//	}

	@Override
	public void run(String... args) throws Exception {

		List<Status> statusList = statusService.listStatus();
		System.out.println(statusList);

		//insert
//		String email = "dickanirwansyah@gmail.com,irmakhairunnisa@gmail.com";
//		System.out.print(splitEmail(email));

//		Leads leadsInsert = Leads.builder()
//				.email("irma@gmail.com")
//				.name("irma khairunnisa")
//				.active(true)
//				.build();
//		boolean insert = leadsService.insertWithSplit(leadsInsert);
//		if (insert == true){
//			System.out.println("Data : "+leadsInsert);
//		}else{
//			System.out.println("NO");
//		}

//		//find email by store procedure
//		Leads leadsEmail = leadsService.findLeadsByEmail("sitasinthyaz@gmail.com");
//		if (leadsEmail != null){
//			System.out.println("DATA EMAIL : "+leadsEmail.getEmail());
//		}else{
//			System.out.println("NOT FOUND");
//		}
//
//		//update
//		Leads leadsUpdate = Leads.builder()
//				.id(5)
//				.email("sitasinthyaz@gmail.com")
//				.name("sita sinthya")
//				.active(true)
//				.build();
//		boolean update = leadsService.update(leadsUpdate);
//		if (update == true){
//			System.out.println("Data : "+leadsUpdate);
//		}else{
//			System.out.println("NO");
//		}
//
//		//delete
//		boolean delete = leadsService.delete(6);
//		if (delete == true){
//			System.out.println("Data : success delete");
//		}else{
//			System.out.println("Failed");
//		}
//
//		//list
//		List<Leads> leads = leadsService.leadsList();
//		System.out.println("Data : " + leads.toString());
	}
}

/** link tutorial **/
// http://blog.itpub.net/69926045/viewspace-2646341/

//@Component
//class CommandData implements CommandLineRunner {
//
//	@Autowired
//	private NasabahMapper nasabahMapper;
//
//	@Override
//	public void run(String... args) throws Exception {
////		Nasabah nasabah = new Nasabah();
////		nasabah.setId(6);
////		nasabah.setFirstName("Fanny Oktafiani");
////		nasabah.setLastName("Oktafizayni");
////		nasabah.setEmail("fanny@gmail.com");
////		nasabah.setPhone("98998789");
////		nasabah.setDob(new Date());
////		nasabah.setCreatedAt(new Date());
////		nasabah.setUpdatedAt(new Date());
////		nasabahMapper.updateNasabah(nasabah);
////		System.out.println(nasabah.toString());
////		Optional<Nasabah> nasabah = nasabahMapper.findNasabahById(90);
////		if (nasabah.isPresent()){
////			System.out.println("data nasabah : "+nasabah.toString());
////		}else{
////			System.out.println("data nasabah not found.");
////		}
//	}
//}