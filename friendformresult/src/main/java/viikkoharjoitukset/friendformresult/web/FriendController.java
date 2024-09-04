package viikkoharjoitukset.friendformresult.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import viikkoharjoitukset.friendformresult.domain.Friend;

@Controller
public class FriendController {

    private List<Friend> friends;

    public FriendController() {
        this.friends = new ArrayList<>();
    }

    @GetMapping("/addfriend")
    public String showForm(Model model) {
        model.addAttribute("friend", new Friend());
        return "friendform";
    }

    @PostMapping("/addfriend")
    public String submitForm(@ModelAttribute Friend friend) {
        friends.add(friend);
        return "redirect:/friends";
    }

    @GetMapping("/friends")
    public String listFriends(Model model) {
        model.addAttribute("friends", friends);
        return "friendlist";
    }
}