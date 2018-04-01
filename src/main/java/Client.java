import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
}
