import { postForm,PREFIX } from '../../axios/tools'



const updateArtworkPostTime = (parameters) => {
  const url = `${PREFIX}moyiManager/updateArtwork/moyiId/artworkId/artworkVersion/property/newValueExpr/tokensExpr/`
  //need to provide artworkId, new value, and verison
  const property = 'postTime' 
  const moyiId='M000001'
  const tokensExpr='none'


  const requestParameters = { ...parameters, tokensExpr, property,moyiId }
  return postForm({ url,requestParameters})
}

const ArtworkServiceEx = {updateArtworkPostTime}
export default ArtworkServiceEx

