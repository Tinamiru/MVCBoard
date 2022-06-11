package boardController;

import java.util.*;

import boardService.BoardServiceImpl;
import boardService.IBoardService;
import boardVO.BoardVO;
import boardView.BoardView;

public class BoardController {

    private final IBoardService bService;


    Scanner sc = new Scanner(System.in);

    public BoardController() {
        bService = BoardServiceImpl.getInstance();
    }

    public void menuController() {

        int choice;
        do {
            BoardView.displayMenu(); // 메뉴 출력
            choice = Integer.parseInt(sc.nextLine()); // 메뉴번호 입력받기
            switch (choice) {
                case 1:
                    displayAll(); // 전체 목록 출력
                    break;
                case 2:
                    newBoard();// 새글작성
                    break;
                case 3:
                    updateBoard();// 수정
                    break;
                case 4:
                    deleteBoard();// 삭제
                    break;
                case 5:
                    searchBoard();// 검색
                    break;
                case 6: // 작업 끝
                    System.out.println("작업을 마칩니다.");
                    break;
                default:
                    System.out.println("번호를 잘못 입력했습니다. 다시입력하세요");
            }
        } while (choice != 6);

    }

    /**
     * 게시글 검색 메소드
     */
    private void searchBoard() {
        BoardVO bv = new BoardVO();
        System.out.println();
        System.out.println("=============================================");
        System.out.println("\t\t\t\t게시글 검색");
        System.out.println("=============================================");

        System.out.print("제목 >> ");
        String bTitle = sc.nextLine();

        System.out.print("작성자 >> ");
        String bWriter = sc.nextLine();

        System.out.print("글 내용 >> ");
        String bContent = sc.nextLine();
        System.out.println();
        
        bv.setbTitle(bTitle);
        bv.setbWriter(bWriter);
        bv.setbContent(bContent);

        List<BoardVO> bList = bService.searchBoard(bv);

        if (bList.size() == 0) {
            System.out.println("회원정보가 없습니다.");
        } else {
            for (BoardVO bv2 : bList) {
                System.out.println();
                System.out.println("=========================| 글번호 : " + bv.getbNo() + " |=============================");
                System.out.println("제목 : " + bv.getbTitle() + "\t\t작성자 : " + bv.getbWriter());
                System.out.println("작성일 : " + bv.getbDate());
                System.out.println("------------------------------ 내용 --------------------------------");
                System.out.println(bv.getbContent());
                System.out.println("===================================================================");
            }
        }
        System.out.println("출력 작업 끝...");
    }


    /**
     * 게시글 삭제 메소드
     */
    private void deleteBoard() {
        BoardVO bv = new BoardVO();

        System.out.println();
        System.out.println("=============================================");
        System.out.println("\t\t\t\t게시글 삭제");
        System.out.println("=============================================");

        boolean isExist;
        String bTitle;
        do {
            System.out.print("제목 >> ");
            bTitle = sc.nextLine();

            isExist = checkMember(bTitle);

            if (!isExist) {
                System.out.println("제목이 " + bTitle + "인 게시글은 "
                        + "존재하지 않습니다.");
                System.out.println("다시 입력해 주세요.");
            }

        } while (!isExist);

        System.out.print("작성자 >> ");
        String bWriter = sc.nextLine();
        bv.setbTitle(bTitle);
        bv.setbWriter(bWriter);

        int cnt = bService.deleteBoard(bv);

        if (cnt > 0) {
            System.out.println("====================================");
            System.out.println("제목 : \"" + bTitle + "\"\t 작성자 : \"" + bWriter + "\"");
            System.out.println("====================================");
            System.out.println("게시글 삭제 성공");
        } else {
            System.out.println("====================================");
            System.out.println("제목 : \"" + bTitle + "\"\t 작성자 : \"" + bWriter + "\"");
            System.out.println("====================================");
            System.out.println("게시글 삭제 실패");
        }


    }

    /**
     * 게시글 수정 메소드
     */
    private void updateBoard() {
        BoardVO bv = new BoardVO();

        System.out.println("=============================================");
        System.out.println("\t기존 게시글 수정 (제목은 수정이 불가합니다.");
        System.out.println("=============================================");

        boolean isExist;
        String bTitle;
        do {
            System.out.print("제목 >> ");
            bTitle = sc.nextLine();

            isExist = checkMember(bTitle);

            if (!isExist) {
                System.out.println("제목이 " + bTitle + "인 게시글은 "
                        + "존재하지 않습니다.");
                System.out.println("다시 입력해 주세요.");
            }

        } while (!isExist);


        System.out.print("작성자 >> ");
        String bWriter = sc.nextLine();

        System.out.print("글 내용 >> ");
        String bContent = sc.nextLine();

        bv.setbTitle(bTitle);
        bv.setbWriter(bWriter);
        bv.setbContent(bContent);

        int cnt = bService.updateBoard(bv);

        if (cnt > 0) {
            System.out.println("제목 \"" + bv.getbTitle() + "\"의 글 수정 성공");
        } else {
            System.out.println("제목 \"" + bv.getbTitle() + "\"의 글 수정 실패");
        }
    }

    /**
     * 게시글 신규 작성 메소드
     */
    private void newBoard() {
        BoardVO bv = new BoardVO();
        System.out.println();
        System.out.println("=============================================");
        System.out.println("\t\t\t\t신규 게시글 작성");
        System.out.println("=============================================");

        System.out.print("제목 >> ");
        String bTitle = sc.nextLine();

        System.out.print("작성자 >> ");
        String bWriter = sc.nextLine();

        System.out.print("글 입력 >> ");
        String bContent = sc.nextLine();

        bv.setbTitle(bTitle);
        bv.setbWriter(bWriter);
        bv.setbContent(bContent);

        int cnt = bService.insertBoard(bv);

        if (cnt > 0) {
            System.out.println("제목 \"" + bv.getbTitle() + "\"의 글 등록 성공");
        } else {
            System.out.println("제목 \"" + bv.getbTitle() + "\"의 글 등록 실패");
        }

    }

    /**
     * 모든 게시판을 출력하는 메서드
     */
    private void displayAll() {

        List<BoardVO> bList = bService.getAllBoardList();
        if (bList.size() == 0) {
            System.out.println("회원정보가 없습니다.");
        } else {
            for (BoardVO bv : bList) {
                System.out.println();
                System.out.println("=========================| 글번호 : " + bv.getbNo() + " |=============================");
                System.out.println("제목 : " + bv.getbTitle() + "\t\t작성자 : " + bv.getbWriter());
                System.out.println("작성일 : " + bv.getbDate());
                System.out.println("------------------------------ 내용 --------------------------------");
                System.out.println(bv.getbContent());
                System.out.println("===================================================================");
            }
        }
        System.out.println();
        System.out.println("출력 작업 끝...");
        System.out.println();

    }

    /**
     * 게시판 존재유무 판단 메서드
     */
    private boolean checkMember(String bTitle) {

        return bService.checkBoard(bTitle);
    }
}
