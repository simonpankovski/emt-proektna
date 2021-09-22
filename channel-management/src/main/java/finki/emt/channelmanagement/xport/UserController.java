package finki.emt.channelmanagement.xport;

import finki.emt.channelmanagement.domain.models.Channel;
import finki.emt.channelmanagement.domain.models.User;
import finki.emt.channelmanagement.domain.models.UserId;
import finki.emt.channelmanagement.domain.service.ChannelService;
import finki.emt.channelmanagement.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final ChannelService channelService;


    @GetMapping("/user/{email:.+}")
    public User getUser(@PathVariable String email){

        System.out.println(email);

        if(userService.findByEmail(email).isPresent()){
            return userService.findByEmail(email).get();
        }
        return null;
    }


    @PostMapping("/new")
    public void saveUser(@RequestBody User user){
        User temp = new User(user.getName(),user.getEmail(),user.getPassword());
        if(userService.findByEmail(temp.getEmail()).isEmpty()){
            userService.saveUser(temp);
        }
    }
    @PostMapping("/subscribe/user/{email:.+}/channel/{channelName}")
    void addSubscribedto(@PathVariable String email,@PathVariable String channelName){
        Optional<User> user = userService.findByEmail(email);
        Optional<Channel> channel = channelService.findByName(channelName);
        User us = user.get();
        Channel ch = channel.get();
        us.setSubscribedTo(ch);
        userService.saveUser(us);
           }
    @PostMapping("/save_channel/user/{email}/channel/{channelName}")
   void createChannel(@PathVariable String email,@PathVariable String channelName, @RequestBody(required = false) String about){
        Optional<User> user = userService.findByEmail(email);
        Optional<Channel> channel = channelService.findByName(channelName);



        User us = user.get();
        Channel ch = new Channel(channelName, us);
        ch.setAbout(about);
        channelService.saveChannel(ch);
        userService.addChannel(us, ch);
    }
}
