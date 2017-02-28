package com.M2ACSI.boundary;

import  com.M2ACSI.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource
interface DemandeRessource extends JpaRepository<Demande, Long> {
	// On veut gerer les requetes GET POST PUT DELETE PATCH

}
