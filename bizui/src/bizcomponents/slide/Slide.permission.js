

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Slide.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (slide,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{slide.id}</Description> 
<Description term="名称">{slide.name}</Description> 
<Description term="顺序">{slide.displayOrder}</Description> 
<Description term="图片链接"><ImagePreview imageTitle="图片链接" imageLocation={slide.imageUrl}/></Description> 
<Description term="视频网址"><ImagePreview imageTitle="视频网址" imageLocation={slide.videoUrl}/></Description> 
<Description term="链接网址">{slide.linkToUrl}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = slide => {
  const {SlideBase} = GlobalComponents
  return <PermissionSetting targetObject={slide}  targetObjectMeta={SlideBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SlidePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  slide = this.props.slide
    const { id,displayName,  } = slide
    const  returnURL = `/slide/${id}/workbench`
    const cardsData = {cardsName:"轮播内容",cardsFor: "slide",cardsSource: slide,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  slide: state._slide,
}))(Form.create()(SlidePermission))

