
package am.basicweb.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user", schema = "Test")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false, updatable = false, length = 32, unique = true)
    private long id;
    private String name;
    @NotBlank
    @NotEmpty
    @NotNull
    private String surname;
    @Size(min = 10, max = 123, message = "C")
    private String username;
    private int age;
    private String password;
    @Transient
    private String code;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Card card;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "id",nullable =true)
    private List<Action> actions;
}

