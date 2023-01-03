import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/aragon/user/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/aragon/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/aragon/user/logout',
    method: 'post'
  })
}
