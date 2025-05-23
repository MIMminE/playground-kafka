package nuts.playgroud.kafka.repo.datagenerator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class AirportVisitor {
    private String id;                    // 방문객 고유 ID
    private String name;                  // 이름
    private String passportNumber;        // 여권 번호
    private String flightNumber;          // 항공편 번호
    private LocalDateTime visitTime;      // 방문 시간
    private String nationality;           // 국적
    private String gender;                // 성별
    private int age;                      // 나이
    private String contactNumber;         // 연락처
    private String email;                 // 이메일
    private String visitPurpose;          // 방문 목적 (예: 출국, 환승, 배웅, 마중 등)
    private String companion;             // 동반자 정보(이름 또는 ID)
    private boolean isVip;                // VIP 여부
    private String seatClass;             // 좌석 등급 (예: Economy, Business, First)
    private String checkedBaggage;        // 위탁 수하물 정보
    private String ticketType;            // 티켓 유형 (예: 편도, 왕복)
    private String residenceCountry;      // 거주 국가
    private boolean hasSpecialNeeds;      // 특별 지원 필요 여부
    private String remarks;               // 비고/메모
}
