package com.apple.shop;
//클래스를 다른파일에서 쓸려면 경로 적어 놔야됨

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//상품과 관련된 API는 다 여기 보관하고 싶음
//(비슷한 API는 모아놓는게 보기 좋음)
@Controller //제어
@RequiredArgsConstructor // lombok 문법 : 필수 인수 생성자
public class ItemController {

    private final ItemRepository itemRepository;//itemRepository()에는 new ItemRepository() 들어있음.
    /*
    위의 lombok - @RequireArgsConstructor 없이 쓰려면
    @Autowired // 자동 연결
    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        //스프링한테 시키는거임 new ItemRepository()하나 뽑아서 itemRepository 변수에 넣으라고 시키는 중임
        //니가 알아서 object 하나 뽑으라고
        //착한 spring은 new ItemRepository()해서 변수에 쳐넣어줍니다.
        //그래서 위의 itemRepository 변수엔 new ItemRepository()이런게 들어있고
        //앞으로 new ItemRepository()가 필요할 때 변수를 맘대로 사용하면 됩니다.
        // 이런 식으로 쓰는 걸 dependency injection이라고 하는데 자세한 건 나중에 알아봅시다.
    }
    */

    @GetMapping("/list")
        // 매핑
    String list(Model model) {
        /*var result = itemRepository.findAll();
        System.out.println(result);*/ // 행을 가져다 준다. [com.apple.shop.Item@41756fbc, com.apple.shop.Item@72c47bd, com.apple.shop.Item@6001cc1a]

        /*
        // 리스트 사용법
        List<Object> a = new ArrayList<>();//변수 위에 올려서 정확히 무슨 타입인지
        a.add(30);
        a.add(40);
        System.out.println(a.get(0));
        System.out.println(a.get(1));
        */

        /*
        // Item의 리스트를 불러옴
        List<Item> result2 = itemRepository.findAll();
        System.out.println(result2.get(0));//item 클래스에서 뽑은 object com.apple.shop.Item@41756fbc
        System.out.println(result2.get(0).title);*/

        /*// list.html thymeleaf th:text="${name}"
        List<Item> result3 = itemRepository.findAll();
        model.addAttribute("name", result3);

        return "list.html";*/

        //list.html thymeleaf th:text="${items}
        List<Item> result4 = itemRepository.findAll();
        model.addAttribute("items", result4);
        var a = new Item();

        System.out.println(a.getTitle());

        return "list.html";
    }

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    /*@PostMapping("/add") //add
    String addPost(@RequestParam String title, @RequestParam Integer price) {
        System.out.println(title);
        System.out.println(price);

        //Item 테이블에 저장해주세요
        Item item = new Item();
        item.setTitle(title);
        item.setPrice(price);
        itemRepository.save(item);

        return "redirect:/list";
    }*/

    @PostMapping("/add")
    String addPost(@ModelAttribute Item item) {

        itemRepository.save(item);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {

        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            System.out.println(result.get());
            model.addAttribute("data", result.get());
            return "detail.html";
        } else {
            return "redirect:/list";
        }
    }
}

