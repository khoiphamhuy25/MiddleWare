# MiddleWare

MiddleWare là một ứng dụng Java cho phép gửi và nhận dữ liệu giữa máy chủ (server) và máy khách (client) thông qua các cổng kết nối đã cấu hình.

## Cách sử dụng

1. **Cấu hình kết nối**

   Các thông số kết nối được lưu trữ trong tệp `config.properties`. Hãy đảm bảo rằng bạn đã cập nhật các giá trị sau:

   ```properties
   server_address=localhost
   client_address=localhost
   server_port=9999
   client_port=8888
   ```

2. **Chạy ứng dụng**

Chạy phương thức main trong lớp MiddleWare để bắt đầu kết nối. MiddleWare sẽ đọc các cấu hình từ config.properties và thiết lập kết nối tới server và client.

3. **Gửi và nhận dữ liệu**


- Khi kết nối được thiết lập, bạn có thể gửi tin nhắn từ client tới server và ngược lại.
- Tin nhắn sẽ được hiển thị trên giao diện dòng lệnh.
