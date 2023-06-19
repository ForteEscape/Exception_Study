package hello.exception.api;

import hello.exception.exception.UserException;
import hello.exception.exhandler.ErrorResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api2")
public class ApiExceptionV2Controller {

    @GetMapping("/members/{id}")
    public MemberDtoV2 getMember(@PathVariable("id") String id){

        if (id.equals("ex")){
            throw new RuntimeException("잘못된 사용자");
        }

        if (id.equals("bad")){
            throw new IllegalArgumentException("잘못된 사용자");
        }

        if (id.equals("user-ex")){
            throw new UserException("사용자 오류");
        }

        return new MemberDtoV2(id, "hello " + id);
    }

    @Data
    @AllArgsConstructor
    static class MemberDtoV2{
        private String memberId;
        private String name;
    }
}
