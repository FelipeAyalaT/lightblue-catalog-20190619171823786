package catalog;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import catalog.Inventory;
import catalog.InventoryRepo;
/**
 * REST Controller to manage Inventory database
 */
@RestController
public class CatalogController {

    Logger logger = LoggerFactory.getLogger(CatalogController.class);
	@Autowired
	InventoryRepo itemsRepo;
	
    /**
     * @return all items in inventory
     */
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<?> getInventory() {
        return itemsRepo.findAll();
        //return ResponseEntity.ok("[{\"id\": 1,\"name\":\"one\"},{\"id\":2,\"name\":\"two\"}]");
    }

    /**
     * @return item by id
     */
    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    ResponseEntity<?> getById(@PathVariable long id) {
                if(!itemsRepo.exists(id))
                {
                	return ResponseEntity.notFound().build();
                }
                return ReponseEntity.ok(itemsRepo.findOne(id));
                //return ResponseEntity.ok("{\"id\":1,\"name\":\"one\"}");
    }

}
