package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("== 명언 앱 실행 ==");
        Scanner sc = new Scanner(System.in);

        int lastId = 0;

        Time time = new Time();

        List<Moti> motis = new ArrayList<>();

        while (true) {
            System.out.print("명령어 ) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("종료")) {
                System.out.println("종료합니다.");
                break;
            }

            if (cmd.length() == 0) {
                System.out.println("다시 입력해주세요.");
                continue;
            }

            if (cmd.equals("등록")) {
                int id = lastId + 1;
                System.out.print("명언 : ");
                String content = sc.nextLine().trim();
                System.out.print("작가 : ");
                String author = sc.nextLine().trim();

                Moti moti = new Moti(id, content, author);
                motis.add(moti);

                System.out.println(id + "번 명언이 등록되었습니다.");
                lastId++;

            } else if (cmd.equals("목록")) {
                if (motis.size() == 0) {
                    System.out.println("번호  /   작가  /   명언  ");
                    System.out.println("=".repeat(20));
                    continue;
                }
                System.out.println("번호  /   작가  /   명언  ");
                System.out.println("=".repeat(20));

                for (int i = motis.size() - 1; i >= 0; i--) {
                    Moti moti = motis.get(i);
                    System.out.printf("%d  /   %s  /   %s  \n", moti.getId(), moti.getContent(), moti.getAuthor());
                }


            } else if (cmd.startsWith("상세보기?id=")) {
                int id = Integer.parseInt(cmd.split("=")[1]);

                Moti foundtMoti = null;

                for (Moti moti : motis) {
                    if (moti.getId() == id) {
                        foundtMoti = moti;
                    }
                }

                if (foundtMoti == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                    continue;
                }
                System.out.println("번호 : " + foundtMoti.getId());
                System.out.println("날짜 : ");
                System.out.println("명언 : " +  foundtMoti.getContent());
                System.out.println("작가 : " + foundtMoti.getAuthor());


            } else if (cmd.startsWith("삭제?id=")) {

                int id = Integer.parseInt(cmd.split("=")[1]);

                Moti foundtMoti = null;
                int foundIndex = -1;

                for (int i = 0; i < motis.size(); i++) {
                    Moti moti = motis.get(i);
                    if (moti.getId() == id) {
                        foundtMoti = moti;
                        foundIndex = i;
                        break;
                    }
                }

                if (foundtMoti == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                    continue;
                }

                motis.remove(foundIndex);
                System.out.println(id + "번 명언이 삭제되었습니다.");

            } else if (cmd.startsWith("수정?id=")) {

                int id = Integer.parseInt(cmd.split("=")[1]);

                Moti foundtMoti = null;


                for (Moti moti : motis) {
                    if (moti.getId() == id) {
                        foundtMoti = moti;
                    }
                }

                if (foundtMoti == null) {
                    System.out.println(id + "번 명언은 존재하지 않습니다.");
                    continue;
                }

                System.out.println("명언(기존) :" + foundtMoti.getContent());
                System.out.println("작가(기존) :" + foundtMoti.getAuthor());

                System.out.print("명언 : ");
                String newContent = sc.nextLine().trim();
                System.out.print("작가 : ");
                String newAuthor = sc.nextLine().trim();

                foundtMoti.setContent(newContent);
                foundtMoti.setAuthor(newAuthor);

                System.out.println(id + "번 명언이 수정되었습니다.");

            } else {
                System.out.println("목록에 존재하지 않습니다.");
            }


        }
        sc.close();
    }
}

