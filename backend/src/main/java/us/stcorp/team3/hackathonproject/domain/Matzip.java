package us.stcorp.team3.hackathonproject.domain;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import us.stcorp.team3.hackathonproject.common.BaseTimeEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Matzip extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;
    @NotNull
    private String content;
    @NotNull
    private Integer viewCount;
    @NotNull
    private Float rating;
    @NotNull
    private String thumbnail;
    @NotNull
    private Float naverRating;
    @NotNull
    private Long naverComment;
    private String naverUrl;
    private String address;
    private String price;
    @Enumerated(EnumType.STRING)
    private Category category;
    @NotNull
    private String createdBy;
    @NotNull
    private String modifiedBy;

    private Matzip(String title, String content, String thumbnail, Float naverRating,
        Long naverComment, String naverUrl,
        String address, String price, Category category, String createdBy,
        String modifiedBy) {
        this.title = title;
        this.content = content;
        this.viewCount = 0;
        this.rating = 0f;
        this.thumbnail = thumbnail;
        this.naverRating = naverRating;
        this.naverComment = naverComment;
        this.naverUrl = naverUrl;
        this.address = address;
        this.price = price;
        this.category = category;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public static Matzip of(String title, String content, String thumbnail, Float naverRating,
        Long naverComment, String naverUrl,
        String address, String price, Category category, String createdBy, String modifiedBy) {
        return new Matzip(title, content, thumbnail, naverRating, naverComment,
            naverUrl, address, price, category, createdBy, modifiedBy);
    }
}
