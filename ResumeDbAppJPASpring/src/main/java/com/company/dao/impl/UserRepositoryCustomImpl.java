/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.dao.impl;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 *
 * @author Igrar
 */

@Repository("userDao1")
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager em;
    @Override
    public List<User> getAll(String name, String surname, Integer nationalityId) {

        String jpql = "select u from User u where 1=1 ";
        if (name != null && !name.trim().isEmpty()) {
            jpql += " and u.name=:name ";
        }
        if (surname != null && !surname.trim().isEmpty()) {
            jpql += " and u.surname=:surname ";
        }
        if (nationalityId != null) {
            jpql += " and u.nationality=:nid ";
        }

        Query query = em.createQuery(jpql, User.class);

        if (name != null && !name.trim().isEmpty()) {
            query.setParameter("name", name);
        }
        if (surname != null && !surname.trim().isEmpty()) {
            query.setParameter("surname", surname);
        }
        if (nationalityId != null) {
            query.setParameter("nid", nationalityId);
        }
        
        return query.getResultList();

//        List<User> result = new ArrayList<>();
//        try {
//            Connection con = connect();
//            String sql = "select "
//                    + "    u.*, "
//                    + "    c.nationality as nationality, "
//                    + "    n.name as birthplace "
//                    + "    from user u "
//                    + "    left join country n ON u.nationality_id  = n.id "
//                    + "    left join country c ON u.birthplace_id  = c.id "
//                    + "    where 1=1 ";
//            if (name != null && !name.trim().isEmpty()) {
//                sql += " and u.name=? ";
//            }
//            if (surname != null && !surname.trim().isEmpty()) {
//                sql += " and u.surname=? ";
//            }
//            if (nationalityId != null) {
//                sql += " and u.nationality_id=? ";
//            }
//
//            PreparedStatement stmt = con.prepareStatement(sql);
//
//            int i = 1;
//            if (name != null && !name.trim().isEmpty()) {
//                stmt.setString(i, name);
//                i++;
//            }
//            if (surname != null && !surname.trim().isEmpty()) {
//                stmt.setString(i, surname);
//                i++;
//            }
//            if (nationalityId != null) {
//                stmt.setInt(i, nationalityId);
//
//            }
//            stmt.execute();
//            ResultSet rs = stmt.getResultSet();
//
//            while (rs.next()) {
////                User u = getUser(rs);
////                result.add(u);
//            }
//            con.close();
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        } catch (Exception ex) {
//            Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return result;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        Query q = em.createQuery("select u from User u  where u.email= :e and u.password= :p", User.class);
        q.setParameter("e", email);
        q.setParameter("p", password);

        List<User> list = q.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

//    //------- JPQL ----------
//    @Override
//    public User findByEmail(String email) {
//        Query q = em.createQuery("select u from User u  where u.email= :e", User.class);
//        q.setParameter("e", email);
//        List<User> list = q.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }

    
    
    
//   // --------CriteriaBuilder----------
//        @Override
//    public User findByEmail(String email) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<User> q1 = cb.createQuery(User.class);
//        var postRoot = q1.from(User.class);
//        CriteriaQuery<User> q2 = q1.where(cb.equal(postRoot.get("email"), email));
//        Query query = em.createQuery(q2);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }

    
    
    
//       // --------NamedQuery----------
//        @Override
//    public User findByEmail(String email) {
//        Query query = em.createNamedQuery("User.findByEmail", User.class);
//        query.setParameter("email", email);
//        List<User> list = query.getResultList();
//        if (list.size() == 1) {
//            return list.get(0);
//        }
//        return null;
//    }
    
 
           // --------Native SQL----------
        @Override
    public User findByEmail(String email) {

        Query query = em.createNativeQuery("select * from user where email = ?", User.class);
        query.setParameter(1, email);
        
        List<User> list = query.getResultList();

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }
    
    
    @Override
    public User getById(Integer userId) {
        User u = em.find(User.class, userId);
        return u;
    }

    @Override
    public boolean updateUser(User u) {
        em.merge(u);
        return true;
    }

    @Override
    public boolean removeUser(Integer id) {
        User u = em.find(User.class, id);
        em.remove(u);
        return true;
    }

    private static BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

    @Override
    public boolean addUser(User u) {
        u.setPassword(crypt.encode(u.getPassword()));
        em.persist(u);
        return true;
    }

}
