package tst.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import Ejb_packge.Abonne;
import Ejb_packge.Abonnement;
import Ejb_packge.Admin;
import TST_EJB.servies.GestionAbonneRemote;
import TST_EJB.servies.GestionAdminLocal;

@Path(value="tst")
public class TstResource {
	
	@EJB
	private GestionAdminLocal GestionAdmin;
	private GestionAbonneRemote GestionAbonne;
	
	
	@GET
	@Produces("text/plain")
	public String TST() {
		return "welomme to TST";
	}
	
	
	@GET
	@Path(value="authentifAd/{login}/{pwd}")
	@Produces(MediaType.TEXT_PLAIN)
    public Admin authentifAd(@PathParam(value="login")String login,
		                  @PathParam(value="pwd")String password){
	    return GestionAdmin.authentification(login,password);
	}
	
	
	@GET
	@Path(value="authentifAb/{login}/{pwd}")
	@Produces(MediaType.TEXT_PLAIN)
    public Abonne authentifAb(@PathParam(value="login")String login,
		                  @PathParam(value="pwd")String password){
	    return GestionAbonne.authentification(login,password);
	}
	
	@POST
	@Path(value ="addAb")
	@Produces(MediaType.TEXT_PLAIN)
	public void addAb(Abonne abonne){
        GestionAbonne.addAbonne(abonne);
	}
	
	@PUT
	@Path(value ="updateAb")
	@Produces(MediaType.TEXT_PLAIN)
	public void updateAb(Abonne abonne){
        GestionAbonne.modifyAbonne(abonne);
	}
	
	@DELETE
	@Path(value ="dropAb")
	@Produces(MediaType.TEXT_PLAIN)
	public void dropAb(Abonne abonne){
        GestionAbonne.deleteAbonne(abonne);
	}
	
	@GET
	@Path(value ="searchAb")
	@Produces(MediaType.TEXT_PLAIN)
	public Abonnement searchAb(@QueryParam(value="id") Integer id){
        return GestionAbonne.findAbonnementById(id);
	}
	
	@GET
	@Path(value ="searchAllAb")
	@Produces(MediaType.TEXT_PLAIN)
	public List<Abonnement> searchAllAb(@QueryParam(value="cin") Integer cin){
        return GestionAbonne.findAllAbonnement(cin);
	}
	 
}
