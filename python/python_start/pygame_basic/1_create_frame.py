
import pygame

# 초기화 
pygame.init()

# 화면크기 설정
# 가로크기
screen_width = 480
# 세로크기
screen_height = 640
screen = pygame.display.set_mode((screen_height, screen_width))

# 화면 타이틀 설정
# 게임 이름
pygame.display.set_caption("SS Game")

# 이벤트 루프
# 게임이 진행중인가?
running = True
while running:
    # 어떤 이벤트가 발생하였는가?
    for event in pygame.event.get():
        # 창이 닫히는 이벤트가 발생하였는가?
        if event.type == pygame.QUIT:
            # 진행중이 아님.
            running = False

# pygame 종료
pygame.quit()
