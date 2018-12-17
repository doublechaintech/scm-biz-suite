import React, { Component } from 'react'
import { AutoComplete, Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'

import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
//import PictureEdit from '../../components/PictureEdit'
//import OSSPictureEdit from '../../components/PictureEdit'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
//import ImageUpload from '../../components/ImageUpload'
import styles from './VehicleServiceCompany.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
const fieldLabels = {
  id: 'ID',
  companyName: '商户名称',
  description: '描述',
  operatingStatus: '服务状态',
  addressCity: '所在城市',
  addressDetail: '所在地址',
  availableStoreService: '是否提供门店收车(件)服务',
  availableHomeService: '是否提供上门取车(件)服务',
  openingTime: '营业时间',
  longitude: '经度',
  latitude: '纬度',
  canExemptProxyFee: '可以免除代理费用',
  contactPhone: '联系电话',
  companyImage1: '公司照片1',
  companyImage2: '公司照片2',
  companyImage3: '公司照片3',
  companyImage4: '公司照片4',
  companyImage5: '公司照片5',
  promoteQrcodeImage: '推广二维码',
  orderContact: '订单默认联系人',
  orderContactPhone: '订单默认联系人电话',
  platform: '平台',
}
const testValues = {};
/*
const testValues = {
  companyName: '大成洗车店',
  operatingStatus: '正常',
  addressDetail: '武侯区火车南站西路799号',
  openingTime: '早上8点到下午6点提供服务,周末24小时营业',
  longitude: '105.44923678425458',
  latitude: '32.14653706481031',
  contactPhone: '028-61554793',
  orderContact: '王城武',
  orderContactPhone: '13312345678',
  addressCityId: 'C000001',
  platformId: 'CIP000001',
  description: '这是一个测试文本，目前只包括普通的字符，等会儿测试下特殊字符。\
第一个要测试的是冒号：就是 :\
第二个是逗号：就是 ,\
第三个是单引号：就是 \'\
第四个是双引号：就是 \"',
}
*/
const imageURLPrefix = '//localhost:2090'


const imageKeys = [
  'companyImage1',
  'companyImage2',
  'companyImage3',
  'companyImage4',
  'companyImage5',
  'promoteQrcodeImage',
]


class VehicleServiceCompanyCreateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {
    // const { getFieldDecorator,setFieldsValue } = this.props.form
    const { setFieldsValue } = this.props.form
    //setFieldsValue(testValues)
      
    this.executeCandidateAddressCitySearch("")
    
    
    this.executeCandidatePlatformSearch("")
    
 
    
    
    
  }
  shouldComponentUpdate() {
    return true
  }
  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

  
  executeCandidateAddressCitySearch = (filterKey) =>{

    const {VehicleServiceCompanyService} = GlobalComponents;
    
    const id = "";//not used for now
    const pageNo = 1;
    const future = VehicleServiceCompanyService.requestCandidateAddressCity("city", id, filterKey, pageNo);
    console.log(future);
    

    future.then(candidateAddressCityList=>{
      this.setState({
        candidateAddressCityList
      })

    })

  }	 
  handleCandidateAddressCitySearch = (value) => {
    this.executeCandidateAddressCitySearch(value)
  }

  executeCandidatePlatformSearch = (filterKey) =>{

    const {VehicleServiceCompanyService} = GlobalComponents;
    
    const id = "";//not used for now
    const pageNo = 1;
    const future = VehicleServiceCompanyService.requestCandidatePlatform("carInspectionPlatform", id, filterKey, pageNo);
    console.log(future);
    

    future.then(candidatePlatformList=>{
      this.setState({
        candidatePlatformList
      })

    })

  }	 
  handleCandidatePlatformSearch = (value) => {
    this.executeCandidatePlatformSearch(value)
  }
 



  handleChange = (event, source) => {
    console.log('get file list from change in update change:', source)

    const { fileList } = event
    const { convertedImagesValues } = this.state

    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change:', source)
  }


  render() {
    const { form, dispatch, submitting } = this.props
    const { convertedImagesValues } = this.state

    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const submitCreateForm = () => {
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error)
          return
        }

        const { owner } = this.props
        const imagesValues = mapBackToImageValues(convertedImagesValues)

        const parameters = { ...values, ...imagesValues }
        dispatch({
          type: `${owner.type}/addVehicleServiceCompany`,
          payload: { id: owner.id, type: 'vehicleServiceCompany', parameters },
        })
      })
    }
    const submitCreateFormAndContinue = () => {
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error)
          return
        }
        
        const { owner } = this.props
        const imagesValues = mapBackToImageValues(convertedImagesValues)
        
        const parameters = { ...values, ...imagesValues }
        dispatch({
          type: `${owner.type}/addVehicleServiceCompany`,
          payload: { id: owner.id, type: 'vehicleServiceCompany', parameters, continueNext: true },
        })
      })
    }
    
    const goback = () => {
      const { owner } = this.props
      dispatch({
        type: `${owner.type}/goback`,
        payload: { id: owner.id, type: 'vehicleServiceCompany',listName:'商户列表' },
      })
    }
    const errors = getFieldsError()
    const getErrorInfo = () => {
      const errorCount = Object.keys(errors).filter(key => errors[key]).length
      if (!errors || errorCount === 0) {
        return null
      }
      // eslint-disable-next-line no-unused-vars
      const scrollToField = (fieldKey) => {
        const labelNode = document.querySelector('label[for="${fieldKey}"]')
        if (labelNode) {
          labelNode.scrollIntoView(true)
        }
      }
      const errorList = Object.keys(errors).map((key) => {
        if (!errors[key]) {
          return null
        }
        return (
          <li key={key} className={styles.errorListItem} onClick={() => scrollToField(key)}>
            <Icon type="cross-circle-o" className={styles.errorIcon} />
            <div className={styles.errorMessage}>{errors[key][0]}</div>
            <div className={styles.errorField}>{fieldLabels[key]}</div>
          </li>
        )
      })
      return (
        <span className={styles.errorIcon}>
          <Popover
            title="表单校验信息"
            content={errorList}
            overlayClassName={styles.errorPopover}
            trigger="click"
            getPopupContainer={trigger => trigger.parentNode}
          >
            <Icon type="exclamation-circle" />
          </Popover>
          {errorCount}
        </span>
      )
    }
    

    
    const {candidateAddressCityList} = this.state
    if(!candidateAddressCityList){
      return (<div>等等</div>)
    }
    if(!candidateAddressCityList.candidates){
      return (<div>等等</div>)
    }   
    
    
    const {candidatePlatformList} = this.state
    if(!candidatePlatformList){
      return (<div>等等</div>)
    }
    if(!candidatePlatformList.candidates){
      return (<div>等等</div>)
    }   
    
    
    
    const tryinit  = (fieldName) => {
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }
    
    const availableForEdit= (fieldName) =>{
      const { owner } = this.props
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false
    
    }
    const formItemLayout = {
      labelCol: { span: 10 },
      wrapperCol: { span: 14 },
    }
    const switchformItemLayout = {
      labelCol: { span: 14 },
      wrapperCol: { span: 4 },
    }
    return (
      <PageHeaderLayout
        title="新建一个商户"
        content="新建一个商户"
        wrapperClassName={styles.advancedForm}
      >
        <Card title="基础信息" className={styles.card} bordered={false}>
          <Form  >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.companyName} {...formItemLayout}>
                  {getFieldDecorator('companyName', {
                    rules: [{ required: true, message: '请输入商户名称' }],
                  })(
                    <Input placeholder="请输入商户名称" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.operatingStatus} {...formItemLayout}>
                  {getFieldDecorator('operatingStatus', {
                    rules: [{ required: true, message: '请输入服务状态' }],
                  })(
                    <Input placeholder="请输入服务状态" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.addressDetail} {...formItemLayout}>
                  {getFieldDecorator('addressDetail', {
                    rules: [{ required: true, message: '请输入所在地址' }],
                  })(
                    <Input placeholder="请输入所在地址" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.openingTime} {...formItemLayout}>
                  {getFieldDecorator('openingTime', {
                    rules: [{ required: true, message: '请输入营业时间' }],
                  })(
                    <Input placeholder="请输入营业时间" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.longitude} {...formItemLayout}>
                  {getFieldDecorator('longitude', {
                    rules: [{ required: true, message: '请输入经度' }],
                  })(
                    <Input placeholder="请输入经度" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.latitude} {...formItemLayout}>
                  {getFieldDecorator('latitude', {
                    rules: [{ required: true, message: '请输入纬度' }],
                  })(
                    <Input placeholder="请输入纬度" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.contactPhone} {...formItemLayout}>
                  {getFieldDecorator('contactPhone', {
                    rules: [{ required: true, message: '请输入联系电话' }],
                  })(
                    <Input placeholder="请输入联系电话" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.orderContact} {...formItemLayout}>
                  {getFieldDecorator('orderContact', {
                    rules: [{ required: true, message: '请输入订单默认联系人' }],
                  })(
                    <Input placeholder="请输入订单默认联系人" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.orderContactPhone} {...formItemLayout}>
                  {getFieldDecorator('orderContactPhone', {
                    rules: [{ required: true, message: '请输入订单默认联系人电话' }],
                  })(
                    <Input placeholder="请输入订单默认联系人电话" />
                  )}
                </Form.Item>
              </Col>

            </Row>
          </Form>
        </Card>



        
        <Card title="设置" className={styles.card} bordered={false}>
          <Form  >
            <Row gutter={16}>
            

              <Col lg={8} md={12} sm={24}>
                <Form.Item label={fieldLabels.availableStoreService}  {...switchformItemLayout}>
                  {getFieldDecorator('availableStoreService', {
                    initialValue: false,
                    rules: [{ required: true, message: '请输入是否提供门店收车(件)服务' }],
                    valuePropName: 'checked'
                  })(
                    <Switch checkedChildren="是" unCheckedChildren="否"  placeholder="请输入是否提供门店收车(件)服务bool" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={8} md={12} sm={24}>
                <Form.Item label={fieldLabels.availableHomeService}  {...switchformItemLayout}>
                  {getFieldDecorator('availableHomeService', {
                    initialValue: false,
                    rules: [{ required: true, message: '请输入是否提供上门取车(件)服务' }],
                    valuePropName: 'checked'
                  })(
                    <Switch checkedChildren="是" unCheckedChildren="否"  placeholder="请输入是否提供上门取车(件)服务bool" />
                  )}
                </Form.Item>
              </Col>

              <Col lg={8} md={12} sm={24}>
                <Form.Item label={fieldLabels.canExemptProxyFee}  {...switchformItemLayout}>
                  {getFieldDecorator('canExemptProxyFee', {
                    initialValue: false,
                    rules: [{ required: true, message: '请输入可以免除代理费用' }],
                    valuePropName: 'checked'
                  })(
                    <Switch checkedChildren="是" unCheckedChildren="否"  placeholder="请输入可以免除代理费用bool" />
                  )}
                </Form.Item>
              </Col>

            </Row>
          </Form>  
        </Card>        
        
        





        <Card title="描述" className={styles.card} bordered={false}>
          <Form layout="vertical" hideRequiredMark>
            <Row gutter={16}>
              <Col lg={24} md={24} sm={24}>
                <Form.Item>
                  {getFieldDecorator('description', {
                    rules: [{ required: true, message: '请输入描述' }],
                  })(
                    <TextArea rows={4} placeholder="请输入请输入描述" />
                  )}
                </Form.Item>
              </Col>
      </Row>
          </Form>  
        </Card>



        <Card title="附件" className={styles.card} bordered={false}>
          <Form layout="vertical" hideRequiredMark>
            <Row gutter={16}>

              <Col lg={6} md={12} sm={24}>
                <ImageComponent
                  buttonTitle="公司照片1"
                  handlePreview={this.handlePreview}
                  handleChange={event => this.handleChange(event, 'companyImage1')}
                  fileList={convertedImagesValues.companyImage1}
                />
              </Col>

              <Col lg={6} md={12} sm={24}>
                <ImageComponent
                  buttonTitle="公司照片2"
                  handlePreview={this.handlePreview}
                  handleChange={event => this.handleChange(event, 'companyImage2')}
                  fileList={convertedImagesValues.companyImage2}
                />
              </Col>

              <Col lg={6} md={12} sm={24}>
                <ImageComponent
                  buttonTitle="公司照片3"
                  handlePreview={this.handlePreview}
                  handleChange={event => this.handleChange(event, 'companyImage3')}
                  fileList={convertedImagesValues.companyImage3}
                />
              </Col>

              <Col lg={6} md={12} sm={24}>
                <ImageComponent
                  buttonTitle="公司照片4"
                  handlePreview={this.handlePreview}
                  handleChange={event => this.handleChange(event, 'companyImage4')}
                  fileList={convertedImagesValues.companyImage4}
                />
              </Col>

              <Col lg={6} md={12} sm={24}>
                <ImageComponent
                  buttonTitle="公司照片5"
                  handlePreview={this.handlePreview}
                  handleChange={event => this.handleChange(event, 'companyImage5')}
                  fileList={convertedImagesValues.companyImage5}
                />
              </Col>

              <Col lg={6} md={12} sm={24}>
                <ImageComponent
                  buttonTitle="推广二维码"
                  handlePreview={this.handlePreview}
                  handleChange={event => this.handleChange(event, 'promoteQrcodeImage')}
                  fileList={convertedImagesValues.promoteQrcodeImage}
                />
              </Col>

            </Row>
          </Form>
        </Card>



        <Card title="关联" className={styles.card} bordered={false}>
          <Form  >
            <Row gutter={16}>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.addressCity} {...formItemLayout}>
                  {getFieldDecorator('addressCityId', {
                  	initialValue: tryinit('addressCity'),
                    rules: [{ required: true, message: '请输入所在城市' }],
                  })(
                                
                  <AutoComplete
                    dataSource={candidateAddressCityList.candidates}
                    
                    
                    onSearch={this.handleCandidateAddressCitySearch}
                    placeholder="请输入所在城市"
                    
                    disabled={!availableForEdit('addressCity')}
                  >
                  {candidateAddressCityList.candidates.map(item=>{
                return (<Option key={item.id}>{`${item.name}(${item.id})`}</Option>);
            })}
                  
                  </AutoComplete>
                  )}
                </Form.Item>
              </Col>

              <Col lg={12} md={12} sm={24}>
                <Form.Item label={fieldLabels.platform} {...formItemLayout}>
                  {getFieldDecorator('platformId', {
                  	initialValue: tryinit('platform'),
                    rules: [{ required: true, message: '请输入平台' }],
                  })(
                                
                  <AutoComplete
                    dataSource={candidatePlatformList.candidates}
                    
                    
                    onSearch={this.handleCandidatePlatformSearch}
                    placeholder="请输入平台"
                    
                    disabled={!availableForEdit('platform')}
                  >
                  {candidatePlatformList.candidates.map(item=>{
                return (<Option key={item.id}>{`${item.name}(${item.id})`}</Option>);
            })}
                  
                  </AutoComplete>
                  )}
                </Form.Item>
              </Col>

            </Row>
          </Form>  
        </Card>

        <FooterToolbar>
          {getErrorInfo()}
          <Button type="primary" onClick={submitCreateForm} loading={submitting} htmlType="submit">
            提交
          </Button>
          <Button type="primary" onClick={submitCreateFormAndContinue} loading={submitting}>
            提交并建下一个
          </Button>
          <Button type="danger" onClick={goback} loading={submitting}>
            放弃
          </Button>
        </FooterToolbar>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(VehicleServiceCompanyCreateForm))




