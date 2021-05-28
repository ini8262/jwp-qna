package homework.domain.entity;

import homework.domain.entity.common.TraceDate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/**
 * create table answer
 * (
 *     id          bigint generated by default as identity,
 *     contents    clob,
 *     created_at  timestamp not null,
 *     deleted     boolean   not null,
 *     question_id bigint,
 *     updated_at  timestamp,
 *     writer_id   bigint,
 *     primary key (id)
 * )
 */

@Getter
@NoArgsConstructor
@Entity
public class Answer extends TraceDate {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private User user;

    @Column(nullable = false)
    private boolean deleted;

    @Builder
    private Answer(String contents, Question question, User user) {
        this.contents = contents;
        this.question = question;
        this.user = user;
    }
}