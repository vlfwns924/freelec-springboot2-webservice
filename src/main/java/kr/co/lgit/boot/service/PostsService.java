package kr.co.lgit.boot.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import kr.co.lgit.boot.domain.posts.Posts;
import kr.co.lgit.boot.dto.PostsListResponseDto;
import kr.co.lgit.boot.dto.PostsResponseDto;
import kr.co.lgit.boot.dto.PostsSaveRequestDto;
import kr.co.lgit.boot.dto.PostsUpdateRequestDto;
import kr.co.lgit.boot.repository.PostsRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
		//posts.update(requestDto.getTitle(), requestDto.getContent()); //setter없이 update하려면 이렇게
		posts.setTitle(requestDto.getTitle()); //entity에서 setter를 지양하라고 하지만 사용할수도있다
		posts.setContent(requestDto.getContent());
		return id;
	}
	
	public PostsResponseDto findById (Long id) {
		Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" +id));
		return new PostsResponseDto(entity);
	}
	
	@Transactional
	public List<PostsListResponseDto> findAllDesc(){
		return postsRepository.findAllDesc().stream()
				.map(PostsListResponseDto::new)
				.collect(Collectors.toList());
	}
	
	@Transactional
	public void delete (Long id) {
		Posts posts = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
		postsRepository.delete(posts);
				
	}
}


