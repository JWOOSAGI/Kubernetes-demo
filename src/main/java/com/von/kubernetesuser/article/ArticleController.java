package com.von.kubernetesuser.article;

import com.von.kubernetesuser.article.model.ArticleDTO;
import com.von.kubernetesuser.article.service.ArticleService;
import com.von.kubernetesuser.article.service.ArticleServiceImpl;
import com.von.kubernetesuser.common.component.MessengerVO;
import com.von.kubernetesuser.common.component.PageRequestVO;
import com.von.kubernetesuser.user.model.UserDTO;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping(path="/api/article")
@Slf4j
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})

public class ArticleController {
    private final ArticleServiceImpl service;

    @PostMapping( "")
    public ResponseEntity<MessengerVO> save(Pageable pageable) throws SQLException {
        return ResponseEntity.ok(new MessengerVO());
    }
    @DeleteMapping(path = "/delete")
    public ResponseEntity<MessengerVO> deleteById(@RequestParam Long id)  {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.deleteById(id));
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<ArticleDTO>> findAll( ) {
        log.info("입력받은 정보 : {}" );
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping(path = "/detail")
    public ResponseEntity<Optional<ArticleDTO>> findById(@RequestParam Long id){
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping(path = "/count")
    public ResponseEntity<MessengerVO> count(Pageable pageable) throws SQLException {
        return ResponseEntity.ok(new MessengerVO());
    }

    @GetMapping(path = "/exists/{id}")
    public ResponseEntity<MessengerVO> existById(Pageable pageable) throws SQLException {
        return ResponseEntity.ok(new MessengerVO());
    }

}