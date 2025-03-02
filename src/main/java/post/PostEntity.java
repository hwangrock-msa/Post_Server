package post;

import jakarta.persistence.*;
import lombok.*;
import com.example.postserver.user.UserEntity;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=50)
    private String title;

    @Column(nullable=false)
    private String content;

    @Column(nullable=false)
    private long view;

    @Column(nullable=false)
    private long like;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
