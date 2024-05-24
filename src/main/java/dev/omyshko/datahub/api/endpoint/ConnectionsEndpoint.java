package dev.omyshko.datahub.api.endpoint;

import dev.omyshko.datahub.api.ConnectionsApiDelegate;
import dev.omyshko.datahub.api.model.*;
import dev.omyshko.datahub.data.entity.ConnectionEntity;
import dev.omyshko.datahub.data.repository.ConnectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ConnectionsEndpoint implements ConnectionsApiDelegate {

    private final NativeWebRequest request;

    private final ConnectionRepository connectionRepository;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Connection> createConnection(ConnectionRequest connectionRequest) {
        return ConnectionsApiDelegate.super.createConnection(connectionRequest);
    }

    @Override
    public ResponseEntity<Void> deleteConnection() {
        return ConnectionsApiDelegate.super.deleteConnection();
    }

    @Override
    public ResponseEntity<List<InputField>> getConnectionTypeParameters(ConnectionType connectionType) {
        return ConnectionsApiDelegate.super.getConnectionTypeParameters(connectionType);
    }

    @Override
    public ResponseEntity<List<ConnectionTypeResponse>> getConnectionTypes() {
        List<ConnectionEntity> all = connectionRepository.findAll();
        return ConnectionsApiDelegate.super.getConnectionTypes();
    }
    @Override
    public ResponseEntity<Connection> getConnections() {
        return ConnectionsApiDelegate.super.getConnections();
    }

    @Override
    public ResponseEntity<ConnectionTestResponse> testConnection(Long connectionId) {
        return ConnectionsApiDelegate.super.testConnection(connectionId);
    }

    @Override
    public ResponseEntity<Connection> updateConnection(ConnectionRequest connectionRequest) {
        return ConnectionsApiDelegate.super.updateConnection(connectionRequest);
    }
}
