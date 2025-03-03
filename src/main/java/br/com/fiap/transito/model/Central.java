package br.com.fiap.transito.model;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "central")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Central implements UserDetails {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CENTRAL"
    )
    @SequenceGenerator(
            name = "SEQ_CENTRAL",
            sequenceName = "SEQ_CENTRAL",
            allocationSize = 1
    )
    @Column(name = "ID_CENTRAL")
    private Long idCentral;

    @Column(name = "USER_NAME_CENTRAL")
    private String userNameCentral;

    @Column(name = "SENHA_ACESSO")
    private String senhaAcesso;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN){
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return senhaAcesso;
    }

    @Override
    public String getUsername() {
        return userNameCentral;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getIdCentral() {
        return idCentral;
    }

    public void setIdCentral(Long idCentral) {
        this.idCentral = idCentral;
    }

    public String getUserNameCentral() {
        return userNameCentral;
    }

    public void setUserNameCentral(String userNameCentral) {
        this.userNameCentral = userNameCentral;
    }

    public String getSenhaAcesso() {
        return senhaAcesso;
    }

    public void setSenhaAcesso(String senhaAcesso) {
        this.senhaAcesso = senhaAcesso;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
