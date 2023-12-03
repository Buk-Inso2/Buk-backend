package edu.pe.upao.buk.repositories;

import edu.pe.upao.buk.models.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
