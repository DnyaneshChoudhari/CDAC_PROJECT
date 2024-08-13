// src/hooks/useAuth.js
import { useSelector } from 'react-redux';

export const useAuth = () => {
  const { userInfo } = useSelector((state) => state.user);

  return {
    isAuth: !!userInfo,  // True if userInfo exists
    email: userInfo?.email,  // User email
  };
};
