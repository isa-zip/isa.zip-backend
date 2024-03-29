package backend.zip.domain.user.options;

import backend.zip.domain.enums.ManagementOption;
import backend.zip.domain.user.UserOption;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
//@DynamicInsert
//@DynamicUpdate
public class UserManagementOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_managment_option_id")
    private Long userManagementOptionId;

    @Column(name = "user_management_option")
    private ManagementOption managementOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "user_option_id")
    private UserOption userOption;

}
