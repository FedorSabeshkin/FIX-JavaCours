# Сайт учета пациентов в поликлинике. 

  В связи с трендом цифровизаци гос. структур, задумал проект учета пациентов сельской клиники. 
  
  Авторизовавшись в качестве врача, пользователь может просмотреть страничку содержащию всех людей, зарегистрированных в системе. После приема конкретного человека прикрепленного к поликлинике, врач может изменить его статус в БД на "Болен" или "Здоров".
  
  Для безопасности доступа к данным, что бы получить права врача, нужно пройти офлайн индентификацию непосредственно на рабочем месте и получить специальный код, который нужно будет указать при регистрации. Если специальный код не будет указан, то пользователь будет зарегистрирован, как обычный пациент, что эквивалентно прикреплению его к поликлинике и добавлению его данных в БД всех пациентов.
  
  Если обычному пользователю потребуется сменить место своего проживания, то в ЛК он может открепиться от поликлиники и его данные не будут выводится при вызове команды показа всех пациентов.
