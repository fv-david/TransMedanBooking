package fv.monster.controller;

import fv.monster.dto.ConnectionDto;
import fv.monster.service.ConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ConnectionController {

    @Autowired
    private ConnectionService connectionService;

    @RequestMapping(value = "/admin/connections", method = RequestMethod.POST)
    public ConnectionDto addConnection(@RequestBody ConnectionDto connection) {
        return connectionService.addConnection(connection);
    }

    @RequestMapping(value = "/connections", method = RequestMethod.GET)
    public List<ConnectionDto> getConnections() {
        return connectionService.getAllConnections();
    }

    @RequestMapping(value = "/admin/connections", method = RequestMethod.PUT)
    public ConnectionDto updateConnection(@RequestBody ConnectionDto connection) {
        return connectionService.updateConnection(connection);
    }

    @RequestMapping(value = "/admin/connections/{id}", method = RequestMethod.DELETE)
    public void deleteConnection(@PathVariable Long id) {
        connectionService.deleteConnection(id);
    }
}
