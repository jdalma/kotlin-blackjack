# kotlin-blackjack

> 딜러와 플레이어 중 카드의 합이 21 또는 21에 가장 가까운 숫자를 가지느 쪽이 이기는 게임  
> Ace는 1 또는 11로 계산할 수 있으며, King, Queen, Jack은 각각 10으로 계산한다.  
> 게임을 시작하면 플레이어는 두 장의 카드를 지급 받으며, 두 장의 카드 숫자를 합쳐 21을 초과하지 않으면서 21에 가깝게 만들면 이긴다.  
> 21을 넘지 않을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다.  
> 21을 초과한다면 플레이어는 패배한다. 

***

- [x] 게임에 참여할 사람의 이름을 입력받는다.
   - 쉼표 기준으로 분리한다.
- [x] 플레이어에게 각각 2장의 카드를 나눠준다.
   - 플레이어들에게 나눠준 카드를 `{이름} 카드: {카드}, {카드}, ...` 형식으로 출력한다.
- [x] 각 플레이어들은 가진 카드의 합이 21을 초과하지 않는다면 카드를 계속 뽑을 수 있다.
   - 카드를 뽑는다면 결과를 `{이름} 카드: {카드}, {카드}, ...` 형식으로 출력한다. 
   - 카드를 뽑는 순서는 앞의 사용자가 끝나야 다음 사용자가 뽑을 수 있다.
   - 21이 초과한 상태에서 뽑는다면 다음 사용자로 넘어가도록 할 것이다.
- [x] 사용자들이 모든 결정을 하였다면 결과를 출력한다.
   - `{이름} 카드: {카드}, {카드}, ... - 결과: {합계}` 형식으로 출력한다.
- [x] 딜러도 게임에 참여하며 딜러의 점수가 16이하이면 한 장의 카드를 추가로 받는다.
- [x] 딜러가 21을 초과하면 플레이어가 가지고 있는 패에 상관없이 승리한다.
- [x] 게임을 완료한 후 각 플레이어별로 승패를 출력한다.

```
## 최종 승패
딜러: 1승 1패
pobi: 승 
jason: 패
```

- [x] 게임 참가자들의 베팅 금액을 입력받는다.
- [x] 블랙잭이라면 배팅 금액의 1.5배를 받고 나머지는 승패에 따라 수익을 계산한다.
- [x] 최종 수익에서 베팅 결과를 출력한다.

```
## 최종 수익
딜러: 10000
pobi: 10000 
jason: -20000
```
